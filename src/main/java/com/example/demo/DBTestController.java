package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/db-test")
public class DBTestController {
    
    @Autowired
    private DataSource dataSource;

    @GetMapping
    public String checkConnection() {
        try (Connection conn = dataSource.getConnection()) {
            return "✅ Verbunden mit: " + conn.getMetaData().getURL();
        } catch (SQLException e) {
            return "❌ Fehler bei Verbindung: " + e.getMessage();
        }
    }

    @GetMapping("/ping")
    public String checkDbPing() {
        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(2)) {
                return "✅ Verbindung zur DB ist aktiv!";
            } else {
                return "⚠️ Verbindung zur DB ist nicht gültig!";
            }
        } catch (SQLException e) {
            return "❌ Fehler bei Verbindung: " + e.getMessage();
        }
    }
    

}
