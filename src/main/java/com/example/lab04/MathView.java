package com.example.lab04;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "/index1")
public class MathView extends VerticalLayout{
    private NumberField firstTextField, secondTextField;
    private Label header;
    private HorizontalLayout btnContainer;
    private Button btnPlus, btnMinus, btnDivide, btnMulti, btnMod, btnMax;
    private TextArea result;
        public MathView() {
            firstTextField = new NumberField();
            secondTextField = new NumberField();
            firstTextField.setLabel("Number 1");
            firstTextField.setWidth("550px");
            secondTextField.setLabel("Number2");
            secondTextField.setWidth("550px");

            header = new Label("Operator");
            btnContainer = new HorizontalLayout();
            btnPlus = new Button("+");
            btnMinus = new Button("-");
            btnDivide = new Button("/");
            btnMulti = new Button("x");
            btnMod = new Button("Mod");
            btnMax = new Button("Max");
            btnContainer.add(btnPlus, btnMinus, btnDivide, btnMulti, btnMod, btnMax);

            result = new TextArea();
            result.setWidth("550px");
            result.setLabel("Answer");
            result.setHeight("75px");

            this.add(firstTextField, secondTextField, header, btnContainer, result);

            btnPlus.addClickListener(event -> {
                double num1 = firstTextField.getValue();
                double num2 = secondTextField.getValue();

                String out = WebClient.create()
                        .get()
                        .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                result.setValue(out);
            });

            btnMinus.addClickListener(event -> {
                double num1 = firstTextField.getValue();
                double num2 = secondTextField.getValue();

                String out = WebClient.create()
                        .get()
                        .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                result.setValue(out);
            });

            btnDivide.addClickListener(event -> {
                double num1 = Double.parseDouble(String.valueOf(firstTextField.getValue()));
                double num2 = Double.parseDouble(String.valueOf(secondTextField.getValue()));
                String out = WebClient.create()
                        .get()
                        .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                result.setValue(out);
            });

            btnMulti.addClickListener(event -> {
                double num1 = firstTextField.getValue();
                double num2 = secondTextField.getValue();

                String out = WebClient.create()
                        .get()
                        .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                result.setValue(out);
            });

            btnMod.addClickListener(event -> {
                double num1 = firstTextField.getValue();
                double num2 = secondTextField.getValue();

                String out = WebClient.create()
                        .get()
                        .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                result.setValue(out);
            });

            btnMax.addClickListener(event -> {
                MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
                formData.add("n1", String.valueOf(firstTextField.getValue()));
                formData.add("n2", String.valueOf(secondTextField.getValue()));

                String out = WebClient.create()
                        .post()
                        .uri("http://127.0.0.1:8080/max")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .body(BodyInserters.fromFormData(formData))
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                result.setValue(out);
            });
        }
}
