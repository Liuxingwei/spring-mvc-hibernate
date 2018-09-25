package cn.liuxingwei.spring.mvc.maven.web;

import cn.liuxingwei.spring.mvc.maven.data.SpittleRepository;
import cn.liuxingwei.spring.mvc.maven.entity.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            Model model,
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count
    ) {
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            Model model,
            @PathVariable long spittleId
    ) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value = "/append", method = RequestMethod.GET)
    public String append(
            Model model,
            @RequestParam(value = "message", defaultValue = "") String message,
            @RequestParam(value = "longitude", defaultValue = "0") double longitude,
            @RequestParam(value = "latitude", defaultValue = "0") double latigude
    ) {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date time = new java.sql.Date(utilDate.getTime());
        Spittle spittle = new Spittle(message, time, longitude, latigude);
        model.addAttribute(spittleRepository.createSpittle(spittle));
        return "appendresult";
    }
}
