package com.matmazur;

import com.matmazur.datasource.DatabaseDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRepository {

    private DatabaseDatasource base;

    @Autowired
    public TestRepository(DatabaseDatasource base) {
        this.base = base;
    }

    public List<String> getAll() {
        return base.getDatabase();
    }
}
