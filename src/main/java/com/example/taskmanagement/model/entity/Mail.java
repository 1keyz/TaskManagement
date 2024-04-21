package com.example.taskmanagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {
    private String to;
    private String subject;
    //private String property;
    private boolean verify = false;
    private Map<String, Object> properties;// template içeriğini geliştirdiğim zaman mailin içereceği bilgilere göre properties'e
    // o bilgileri ekleyerek o kendi içerisinde mapleme işlemini yaparek maili gönderecek!!! - atıyorum şimdiki template içerisindeki
    // content yerine tokeni veriyorum.
}
