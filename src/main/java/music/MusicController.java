package music;

import exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/web")//единая точка входа
public class MusicController {

    @GetMapping("/calculator") //по новому формату Get запрос
    public String Calc(@RequestParam(name = "a", required = false) String a,
                       @RequestParam(name = "b", required = false) String b,
                       @RequestParam(name = "action", required = false) String action, Model model) {

        System.out.println("a = " + a);

        System.out.println("b = " + b);

        System.out.println("action = " + action);
        int a_int = Integer.parseInt(a);
        int b_int = Integer.parseInt(b);
        int result_int = 0;
        String calc_result = "";

        switch (action) {
            case "addition":
                result_int = a_int + b_int;
                calc_result = "Result: " + a_int + " + " + b_int + " = " + result_int;
                break;
            case "subtraction":
                result_int = a_int - b_int;
                calc_result = "Result: " + a_int + " - " + b_int + " = " + result_int;
                break;
            case "multiplication":
                result_int = a_int * b_int;
                calc_result = "Result: " + a_int + " * " + b_int + " = " + result_int;
                break;
            case "division":
                if (b_int == 0) {
                    calc_result = "Result: " + a_int + " / " + b_int + " = division by zero!";
                } else {
                    result_int = a_int / b_int;
                    calc_result = "Result: " + a_int + " / " + b_int + " = " + result_int;
                }
                break;
            default:
                calc_result = "Result: action '" + action + "' not found!";
                break;
        }

        model.addAttribute("calc_result", calc_result);

        return "calculator";
    }


}
