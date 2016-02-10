package com.example.rev.retrofitpicaso;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by REVANT on 09-02-2016.
 */
public class repoModel {

    @Expose
    private String name;
    @Expose
    private Integer id;

    @Expose
    private String html_url;

    @Expose
    private String description;;

    public String getName() {
        return name;
    }

    public void setLogin(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.html_url= htmlUrl;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
