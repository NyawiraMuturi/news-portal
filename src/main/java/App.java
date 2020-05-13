import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import dao.UserDao;
import org.sql2o.Sql2o;
import models.Department;
import models.News;
import models.User;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
//import com.google.gson.Gson;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import exceptions.ApiException;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oUserDao userDao;

        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        Connection conn;
        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "its_hanti", "NyawiraAce20");

        userDao = new Sql2oUserDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);


        get("/", (req, resp) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/success", (req, resp) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        //get: show a form to create a new department

        get("/departments/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "department-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/departments/new", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("nameofdepartment");
            String description = req.queryParams("descrptofdepartment");
            String numberofemployees = req.queryParams("numberofemployees");
            Department newDepartment = new Department(name, description, numberofemployees);
            model.put("newDepartment", newDepartment);
            res.redirect("/success");
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Department> departments = Sql2oDepartmentDao.getAll();
            model.put("departments", departments);
            return new ModelAndView(model, "news.hbs");
        }, new HandlebarsTemplateEngine());
        //get: show a form to create a new user

        get("/users/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Department> departments = Sql2oDepartmentDao.getAll();
            model.put("departments", departments);
            return new ModelAndView(model, "employees-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/users/new", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String position = req.queryParams("position");
            String role = req.queryParams("role");
            String iddept = req.queryParams("iddept");

            User newUser = new User(name, position, role,iddept);
            model.put("newUser", newUser);
            res.redirect("/success");
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newEmp", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<User> users = Sql2oUserDao.getAll();
            model.put("departments", users);
            return new ModelAndView(model, "user.hbs");
        }, new HandlebarsTemplateEngine());

        get("/News/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "News-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/news/new", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String newstitle = req.queryParams("newstitle");
            String content = req.queryParams("content");
            int iddept = Integer.parseInt(req.queryParams("iddept"));
            News newDepartment = new News(newstitle, content, iddept);
            model.put("newDepartment", newDepartment);
            res.redirect("/success");
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<News> departments = Sql2oNewsDao.getAll();
            model.put("departments", departments);
            return new ModelAndView(model, "NewsfromDB.hbs");
        }, new HandlebarsTemplateEngine());
    }
}