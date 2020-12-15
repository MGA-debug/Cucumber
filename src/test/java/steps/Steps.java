package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import sberbank.mortgage.freamwork.managers.PageManagers;


public class Steps {

    private PageManagers app = PageManagers.getManagerPages();

    @Когда("^Загружена стартовая страница$")
    public void getHomePag() {
        app.getHomePage();
    }

    @Когда("^Выбрать нужный пункт меню '(.*)'$")
    public void selectMenu(String menuName) {
        app.getHomePage().selectMenu(menuName);
    }

    @Когда("^Выбрать нужный пункт подменю '(.*)'$")
    public void selectSubMenu(String subMenu) {
        app.getHomePage().selectSubMenu(subMenu);
    }

    @Когда("^Нажать кнопку \"подать заявку\"$")
    public void clickApply() {
        app.getMortgagePage().clickApply();
    }

    @Когда("^Заполнить необходимые поля$")
    public void fillFields(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgageFormPage().selectCondition(raw.get(0), raw.get(1));
                }
        );
    }

    @Когда("^Дополнительные услуги снижающие ставку$")
    public void selectAdditionalService(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgageFormPage().selectAdditionalServices(raw.get(0), raw.get(1));
                }
        );
    }

    @Тогда("^Проверяем, что появится ошибка в несоответствии данных$")
    public void check() {
        app.getMortgageFormPage().checkFieldValues();
    }
}
