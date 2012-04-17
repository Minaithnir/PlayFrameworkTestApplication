package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        redirect("/tasks");
    }

    public static void flashRedirect() {
        redirect(flash.get("page"));
    }
}