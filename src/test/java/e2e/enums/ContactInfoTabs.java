package e2e.enums;

import lombok.Getter;

// перебираемый список, передаем его в тесте, обращаясь к названию и значению энама
@Getter // от lombok
public enum ContactInfoTabs {
    INFO("2"),
    PHONES("3"),
    EMAILS("4"),
    ADDRESSES("5");
    public final String value;

    // конструктор
    ContactInfoTabs(String value){
        this.value = value;
    }

}
