package bus.reservation.controller;


import bus.reservation.dto.ClientResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("files")
public class NonRestController {



    @GetMapping("/ticket")
    public String setTicket( ClientResponse clientResponse , Model model){


        model.addAttribute("client", clientResponse ) ;

        return "ticket" ;

    }


}
