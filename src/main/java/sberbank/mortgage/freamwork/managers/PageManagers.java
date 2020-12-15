package sberbank.mortgage.freamwork.managers;

import sberbank.mortgage.freamwork.pages.HomePage;

import sberbank.mortgage.freamwork.pages.MortgageFormPage;
import sberbank.mortgage.freamwork.pages.MortgagePage;

public class PageManagers {

    private static PageManagers pageManagers;

    HomePage homePage;

    MortgagePage mortgagePage;

    MortgageFormPage mortgageFormPage;

    private PageManagers() {
    }

    public static PageManagers getManagerPages() {
        if (pageManagers == null) {
            pageManagers = new PageManagers();
        }
        return pageManagers;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public MortgagePage getMortgagePage() {
        if (mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }

    public MortgageFormPage getMortgageFormPage() {
        if (mortgageFormPage == null) {
            mortgageFormPage = new MortgageFormPage();
        }
        return mortgageFormPage;
    }
}

