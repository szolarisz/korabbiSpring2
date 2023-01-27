package eu.yebo.korabbiSpring2.controllers;

import eu.yebo.korabbiSpring2.domain.Story;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {


    @GetMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @GetMapping("/semmi")
    public String valami(Model model)
    {
        model.addAttribute("pageTitle", "Dr. Kupica oldala");
        model.addAttribute( "headerOne", "Ez Dr. Kupica oldala, bárki is mondja ennek az ellenkezőjét");
        model.addAttribute("stories", getStories());
        return "kupica";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String indul(){
        return "index2";
    }

    @PostMapping("/index")
    @ResponseBody
    public String indexPost(){
        return "index - post";
    }

    private List<Story> getStories(){
        List<Story> result = new ArrayList<>();
    result.add( new Story("Kutya jó cím", "Ez egy kutya jó tartalom, bár rövid", new Date(), "Ki más mint én"));
        result.add( new Story("Második cím", "<span style =  'color:crimson;'>Ez egy kutya</span> jó tartalom, bár rövid", new Date(), "Gróf Anonymous"));
       // result.get( result.size()-1).setPosted( new Date() );
        return result;
    }
}
