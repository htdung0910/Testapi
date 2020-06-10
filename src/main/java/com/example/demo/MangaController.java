package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MangaController {
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    @RequestMapping(value = "/hottestManga", method = RequestMethod.GET)
    public ResponseEntity<String> getHottestManga() {
        List<String> imageThumnail = new ArrayList<>();
        imageThumnail.add("http://st.truyenchon.com/data/comics/127/lieu-lieu-nhan-than-tu-tien-truyen.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/113/mairimashita-iruma-kun.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/143/thong-linh-phi.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/166/vo-yeu-cuoi-truoc-sung-sau.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/249/phong-khoi-thuong-lam.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/141/thien-tai-khoc-bao-tong-tai-sung-the-qua-9731.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/185/kiem-nghich-thuong-khung.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/217/loan-the-tu-sung-thieu-soai-bat-luong-cu-7851.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/90/chung-ta-khong-the-hoc.jpg");
        imageThumnail.add("http://st.truyenchon.com/data/comics/134/tan-tac-long-ho-mon.jpg");
        return new ResponseEntity<>(gson.toJson(imageThumnail),HttpStatus.OK);
    }

}
