package service;

import model.Album;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class AlbumService {
    private static List<Album> list = new ArrayList<>();
    private static List<Category> listCategory = new ArrayList<>();

    static {
        listCategory.add(new Category("Chu tinh"));
        listCategory.add(new Category("Lang mang"));
        listCategory.add(new Category("Cach mang"));
        listCategory.add(new Category("tre"));
        listCategory.add(new Category("Rap"));
    }
    public List<Album> findAll() {
        return list;
    }
    public List<Category> findAllCa() {
        return listCategory;
    }
    public void save(Album album){
        list.add(album);
    }

    public void update(int id, Album album){
        for(Album m : list){
            if(m.getId() == id){
                m = album;
                break;
            }
        }
    }
    public void remove(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
    }
}
