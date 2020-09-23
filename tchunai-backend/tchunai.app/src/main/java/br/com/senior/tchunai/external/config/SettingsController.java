package br.com.senior.tchunai.external.config;

import br.com.senior.tchunai.lib.commom.settings.ApplicationSettings;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class SettingsController {

    @Data
    private static class ApplicationSettingsDto {
        private String appName;
        private String hashKey;
    }

    @Autowired
    private ApplicationSettings settings;

    @GetMapping("settings")
    public SettingsController.ApplicationSettingsDto getSettings() {
        var set = new SettingsController.ApplicationSettingsDto();
        set.setAppName(settings.getName());
        set.setHashKey(settings.getHashSalt());
        return set;
    }
}
