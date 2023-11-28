package e2e.enums;

import lombok.Getter;

@Getter
public enum ContactInfoTabs {
    INFO("Info"),
    PHONES("Phones"),
    EMAILS("E-Mails"),
    ADDRESSES("Addresses");
    public final String value;

    ContactInfoTabs(String value) {
        this.value = value;
    }
}
