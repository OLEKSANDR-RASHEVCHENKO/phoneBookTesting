package e2e.enums;

import lombok.Getter;

// перебираемый список, передаем его в тесте, обращаясь к названию и значению энама
@Getter // от lombok
public enum ContactInfoTabs {
    INFO("1"),
    PHONES("2"),
    EMAILS("3"),
    ADDRESSES("4");
    public final String value;

    // конструктор
    ContactInfoTabs(String value){
        this.value = value;
    }

}
