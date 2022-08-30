package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;


@Route (value = "/index2")
public class CashierView extends VerticalLayout {

    public CashierView() {
        NumberField addBalanceField = new NumberField("เงินทอน");
        addBalanceField.setPrefixComponent(new Span("$"));

        Button getChange = new Button("คำนวณเงินทอน");

        NumberField b1000 = new NumberField();
        b1000.setPrefixComponent(new Span("$1000:"));
        NumberField b500 = new NumberField();
        b500.setPrefixComponent(new Span("$500:"));
        NumberField b100 = new NumberField();
        b100.setPrefixComponent(new Span("$100:"));
        NumberField b20 = new NumberField();
        b20.setPrefixComponent(new Span("$20:"));
        NumberField b10 = new NumberField();
        b10.setPrefixComponent(new Span("$10:"));
        NumberField b5= new NumberField();
        b5.setPrefixComponent(new Span("$5:"));
        NumberField b1 = new NumberField();
        b1.setPrefixComponent(new Span("$1:"));

        this.add(addBalanceField, getChange, b1000, b500, b100, b20, b10, b5, b1);

        getChange.addClickListener(event -> {
            double balance = (addBalanceField.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+balance)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();
            Change money = out;
            b1000.setValue((double) money.getB1000());
            b500.setValue((double) money.getB500());
            b100.setValue((double) money.getB100());
            b20.setValue((double) money.getB20());
            b10.setValue((double) money.getB10());
            b5.setValue((double) money.getB5());
            b1.setValue((double) money.getB1());
        });
    }
}
