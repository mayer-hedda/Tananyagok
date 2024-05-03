package com.mycompany.teszt.Teszteles;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
// @Categories.IncludeCategory(LoginCategory.class)
//@Categories.ExcludeCategory(LoginCategory.class)
@Suite.SuiteClasses({
    MoneyTest.class,
    LoginCategory.class
})
public class RunByCategory {
    
}
