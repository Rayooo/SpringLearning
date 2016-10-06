package com.ray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@SpringBootApplication
@Controller
public class DemoApplication {
    //路由至/
    @GetMapping("/")
    @ResponseBody
    public String greeting(){
        return "<html><head><title>Hello World!</title></head><body><h1>Hello World!</h1><p>This is my first web site</p></body></html>";
    }
    //路由
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/users/{username}")
    @ResponseBody       //返回字符串
    public String userProfile(@PathVariable("username") String userName){
        return String.format("user %s",userName);
    }


    @RequestMapping("/blogs/{id}")
    public String blogs(@PathVariable("id")long id, Model model){
        model.addAttribute("title","This is a blog with id "+id);
        Date date = new Date();
        model.addAttribute("createdTime", date.getTime());
        model.addAttribute("content","AAAA");
        return "blog";
    }

//    private static final int PAGE_SIZE = 10;
//    @GetMapping("/blogs")
//    public List<Blog> blogs(@RequestParam(name = "page", required = false, defaultValue = "1") int page){
//        int start = (page - 1)* PAGE_SIZE;
//        return blogs;
//    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }
    @PostMapping("/create")
    public String create(@RequestParam("title") String title,
                         @RequestParam("content") String content) {
        System.out.print(title);
        System.out.print(content);
        return "redirect:/blogs/"+title;
    }

    //错误处理,不能用error,重定义了
    @RequestMapping("/errorTest")
    public String testException() {
        System.out.print("A");
        throw new RuntimeException("this is a test exception");
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
