package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MangaController {
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    @RequestMapping(value = "/hottestManga", method = RequestMethod.GET)
    public ResponseEntity<String> getHottestManga() {
        List<String> listTemp = new ArrayList<>();
        listTemp.add("http://st.truyenchon.com/data/comics/127/lieu-lieu-nhan-than-tu-tien-truyen.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/113/mairimashita-iruma-kun.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/143/thong-linh-phi.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/166/vo-yeu-cuoi-truoc-sung-sau.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/249/phong-khoi-thuong-lam.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/141/thien-tai-khoc-bao-tong-tai-sung-the-qua-9731.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/185/kiem-nghich-thuong-khung.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/217/loan-the-tu-sung-thieu-soai-bat-luong-cu-7851.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/90/chung-ta-khong-the-hoc.jpg");
        listTemp.add("http://st.truyenchon.com/data/comics/134/tan-tac-long-ho-mon.jpg");


        List<Manga> imageThumnail = new ArrayList<>();
        for (int i = 0; i < listTemp.size(); i++){
            Manga x = new Manga();
            x.setTitle("Title "+i);
            x.setThumnailPath(listTemp.get(i));
            imageThumnail.add(x);
        }

        return new ResponseEntity<>(gson.toJson(imageThumnail),HttpStatus.OK);
    }

    @RequestMapping(value = "/hottestMangaTest", method = RequestMethod.GET)
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>(gson.toJson("Hello"),HttpStatus.OK);
    }

    @RequestMapping(value = "/hottestMangaTest123", method = RequestMethod.GET)
    public ResponseEntity<String> getTest123() {
        return new ResponseEntity<>(gson.toJson("Hello123"),HttpStatus.OK);
    }
}
