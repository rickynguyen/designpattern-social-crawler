package app;

import controller.Controller;
import crawler.FacebookCrawler;
import crawler.VnExpressCrawler;
import crawler.YoutubeCrawler;
import processing.CountNumberChildrenProcessor;
import processing.CountNumberLikeDislikeProcessor;
import processing.SimpleDataProcessor;
import processing.TreeDataProvider;
import view.DataView;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    private DataView currentView;
    private String queryString = "Cam ly";
    private String currentControllerName;
    private String currentActionName;

    private TreeDataProvider dataProvider;

    private static Application objInstance;

    synchronized public static Application getInstance() {
        if (null == Application.objInstance) {
            Application.objInstance = new Application();
        }
        return Application.objInstance;
    }

    public String getQueryString() {
        return queryString;
    }

    synchronized public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public TreeDataProvider getDataProvider() {
        return dataProvider;
    }

    public void navigateTo(String controller, String action, Object data) throws Exception {

        if (Objects.equals(controller, currentControllerName) && Objects.equals(action, currentActionName)) {
            return;
        }
        currentControllerName = controller;
        currentActionName = action;

        String className = "controller" + '.' + controller;
        Class<?> clazz = Class.forName(className);
        Controller object = (Controller) clazz.newInstance();
        Method method;
        if (data == null) {
            method = clazz.getMethod(action);
        }
        else {
            method = clazz.getMethod(action, data.getClass());
        }

        DataView view;
        if (method.getParameterCount() == 1 ){
            view = (DataView) method.invoke(object, data);
        }
        else {
            view = (DataView) method.invoke(object);
        }
        if (currentView != null) {
            currentView.hide();
        }
        currentView = view;
        currentView.show();

        System.out.println(String.format("Navigate to %s %s", controller, action));
    }

    private void startScheduleJobs() {

        Runnable runnable = () -> {
            try {
                System.out.println(String.format("Background run at %s", new Date()));
                this.getDataProvider().query(this.getQueryString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(runnable, 1, 10, TimeUnit.SECONDS);
    }

    private Application() {
        this.dataProvider = new TreeDataProvider(Arrays.asList(
                new FacebookCrawler(),
                new YoutubeCrawler(),
                new VnExpressCrawler()
        ), new CountNumberChildrenProcessor(new CountNumberLikeDislikeProcessor(new SimpleDataProcessor())));

        startScheduleJobs();
    }
}
