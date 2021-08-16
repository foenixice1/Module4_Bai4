package service;

import model.UppFile;

import java.util.ArrayList;

public class UppFileService {
    public ArrayList<UppFile> list = new ArrayList<>();

    public UppFileService() {
        list.add(new UppFile("nam","https://vcdn-dulich.vnecdn.net/2020/09/04/1-Meo-chup-anh-dep-khi-di-bien-9310-1599219010.jpg"));
        list.add(new UppFile("nu","https://media.travelmag.vn/files/thuannguyen/2020/04/25/cach-chup-anh-dep-tai-da-lat-1-2306.jpeg"));
    }

    public void save(UppFile uppFile) {
        list.add(uppFile);
    }
    public void delete(int index){
        list.remove(index);
    }
    public void edit(UppFile uppFile, int index){
        list.set(index,uppFile);
    }
}
