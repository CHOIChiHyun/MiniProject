package calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class CalculatorController implements Initializable {
    @FXML
    private Button btnClose;
    @FXML
    private Button btnPoint;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnClear;
    @FXML
    private Label result;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn6;
    @FXML
    private Button btnSub;
    @FXML
    private Button btn7;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn2;
    @FXML
    private Button btnMul;
    @FXML
    private Button btn3;
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btnResult;
    @FXML
    private Button btnBackspace;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnClose.setOnAction(event -> Platform.exit());
        btnClear.setOnAction(event -> handleBtnClearAction(event));
        btnResult.setOnAction(event -> handleBtnResultAction(event));
        btnBackspace.setOnAction(event -> handleBtnBackspaceAction(event));

        btn0.setOnAction(event -> handleBtn0Action(event));
        btn1.setOnAction(event -> handleBtn1Action(event));
        btn2.setOnAction(event -> handleBtn2Action(event));
        btn3.setOnAction(event -> handleBtn3Action(event));
        btn4.setOnAction(event -> handleBtn4Action(event));
        btn5.setOnAction(event -> handleBtn5Action(event));
        btn6.setOnAction(event -> handleBtn6Action(event));
        btn7.setOnAction(event -> handleBtn7Action(event));
        btn8.setOnAction(event -> handleBtn8Action(event));
        btn9.setOnAction(event -> handleBtn9Action(event));

        btnAdd.setOnAction(event -> handleBtnAddAction(event));
        btnSub.setOnAction(event -> handleBtnSubAction(event));
        btnMul.setOnAction(event -> handleBtnMulAction(event));
        btnDiv.setOnAction(event -> handleBtnDivAction(event));

        Platform.runLater(() -> {
            result.getScene().setOnKeyPressed(event -> {
                KeyCode code = event.getCode();
                boolean isShiftPressed = event.isShiftDown();

                switch (code) {
                    case DIGIT0:
                    case NUMPAD0:
                        handleBtn0Action(null);
                        break;
                    case DIGIT1:
                    case NUMPAD1:
                        handleBtn1Action(null);
                        break;
                    case DIGIT2:
                    case NUMPAD2:
                        handleBtn2Action(null);
                        break;
                    case DIGIT3:
                    case NUMPAD3:
                        handleBtn3Action(null);
                        break;
                    case DIGIT4:
                    case NUMPAD4:
                        handleBtn4Action(null);
                        break;
                    case DIGIT5:
                    case NUMPAD5:
                        handleBtn5Action(null);
                        break;
                    case DIGIT6:
                    case NUMPAD6:
                        handleBtn6Action(null);
                        break;
                    case DIGIT7:
                    case NUMPAD7:
                        handleBtn7Action(null);
                        break;
                    case DIGIT8:
                        if (isShiftPressed) {
                            handleBtnMulAction(null);
                        } else {
                            handleBtn8Action(null);
                        }
                        break;
                    case NUMPAD8:
                        handleBtn8Action(null);
                        break;
                    case DIGIT9:
                    case NUMPAD9:
                        handleBtn9Action(null);
                        break;
                    case ADD:
                    case PLUS:
                        handleBtnAddAction(null);
                        break;
                    case EQUALS:
                        if (isShiftPressed) {
                            handleBtnAddAction(null);
                        } else {
                            handleBtnResultAction(null);
                        }
                        break;
                    case SUBTRACT:
                    case MINUS:
                        handleBtnSubAction(null);
                        break;
                    case MULTIPLY:
                    case ASTERISK:
                        handleBtnMulAction(null);
                        break;
                    case DIVIDE:
                    case SLASH:
                        handleBtnDivAction(null);
                        break;
                    case ENTER:
                        handleBtnResultAction(null); // 엔터 키 → = 버튼 실행
                        break;
                    case ESCAPE:
                    case DELETE:
                        handleBtnClearAction(null); // 백스페이스 → Clear 버튼 실행
                        break;
                    case BACK_SPACE:
                        handleBtnBackspaceAction(null);
                        break;
                    case F4:
                        Platform.exit();
                        break;
                    default:
                        break;
                }
            });
        });
    }

    private int calResult = 0;
    ArrayList<Integer> number = new ArrayList<Integer>();
    ArrayList<String> strNumber = new ArrayList<String>();
    ArrayList<String> oper = new ArrayList<String>();
    Calculator calculator = new Calculator();

    private void handleBtn0Action(ActionEvent event) {
        displayNumber(btn0);
    }

    private void handleBtn1Action(ActionEvent event) {
        displayNumber(btn1);
    }

    private void handleBtn2Action(ActionEvent event) {
        displayNumber(btn2);
    }

    private void handleBtn3Action(ActionEvent event) {
        displayNumber(btn3);
    }

    private void handleBtn4Action(ActionEvent event) {
        displayNumber(btn4);
    }

    private void handleBtn5Action(ActionEvent event) {
        displayNumber(btn5);
    }

    private void handleBtn6Action(ActionEvent event) {
        displayNumber(btn6);
    }

    private void handleBtn7Action(ActionEvent event) {
        displayNumber(btn7);
    }

    private void handleBtn8Action(ActionEvent event) {
        displayNumber(btn8);
    }

    private void handleBtn9Action(ActionEvent event) {
        displayNumber(btn9);
    }

    private void handleBtnAddAction(ActionEvent event) {
        saveNumber();
        handleOperator(btnAdd);
    }

    private void handleBtnSubAction(ActionEvent event) {
        saveNumber();
        handleOperator(btnSub);
    }

    private void handleBtnMulAction(ActionEvent event) {
        saveNumber();
        handleOperator(btnMul);
    }

    private void handleBtnDivAction(ActionEvent event) {
        saveNumber();
        handleOperator(btnDiv);
    }

    private void handleBtnResultAction(ActionEvent event) {
        saveNumber();
        calculate();
    }

    private void handleBtnClearAction(ActionEvent event) {
        result.setText("");
        arrayClear();
        System.out.println("CLEAR SUCCESS!!");
    }

    private void handleBtnBackspaceAction(ActionEvent event) {
        int length = strNumber.size();
        strNumber.remove(length - 1);
        String backspaceNumber = "";
        for (int i = 0; i < strNumber.size(); i++) {
            backspaceNumber += strNumber.get(i);
        }
        result.setText(backspaceNumber);
    }

    private void calculate() {
        //입력된 숫자가 2개가 안되면 연산 진행 안하고 calculate 메서드 종료
        if (number.size() < 2) {
            return;
        }

        switch (oper.get(0)) {
            case "+":
                calResult = number.get(0) + number.get(1);
                break;
            case "-":
                calResult = number.get(0) - number.get(1);
                break;
            case "X":
                calResult = number.get(0) * number.get(1);
                break;
            case "/":
                try {
                    calResult = number.get(0) / number.get(1);
                } catch (ArithmeticException e) {
                    System.out.println("Arithmatic Exception 발생!");
                }
//                calResult = number.get(0) / number.get(1);
                break;
            default:
                break;
        }

        String strResult = Integer.toString(calResult);
        result.setText(strResult);
        number.clear();
        number.add(calResult);
        System.out.println("계산 결과 = " + calResult);
    }

    private void displayNumber(Button button) {
        if (result.getText().equals("+") || result.getText().equals("-") || result.getText().equals("X") || result.getText().equals("/")) {
            result.setText("");
        }
        String inputNumber = button.getText();
        strNumber.add(inputNumber);
        String setNumber = "";
        for (int i = 0; i < strNumber.size(); i++) {
            setNumber += strNumber.get(i);
        }
        result.setText(setNumber);
    }

    private void saveNumber() {
        try {
            String num = "";
            for (int i = 0; i < strNumber.size(); i++) {
                num += strNumber.get(i);
            }
            strNumber.clear();
            number.add(Integer.parseInt(num));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 발생!");
            System.out.println("현재 저장된 Number = " + number.get(0));
        }
    }

    private void arrayClear() {
        number.clear();
        oper.clear();
        strNumber.clear();
    }

    private void handleOperator(Button button) {
        result.setText(button.getText());

        if (!oper.isEmpty()) {
            calculate();
            oper.clear();
        }

        oper.add(button.getText());
    }
}
