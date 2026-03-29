package com.example.chatroom;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField messageInput;

    @FXML
    private Label  messageReceive;

    @FXML
    private Label messageReceiveAnswer;

    @FXML
    private Label  messageSend;

    @FXML
    private Label participantsInfo;

    @FXML
    private Button muteButtonLabel;

    @FXML
    protected void onConnectButtonClick(){
        //fetch data of both callers
        participantsInfo.setText("- Participant A\n- Participant B");
    }

    @FXML
    protected void onSendButtonClick() {
        String message = messageInput.getText();
        messageSend.setText("You: \n%s".formatted(message));
        messageInput.clear();
        messageReceiveAnswer.setText("Them:\nHAHA you are so FUNNY! :D");
    }

    @FXML
    protected void onMuteButtonClick(){
        if (muteButtonLabel.getText().equals("Mute")){
            //set microphone to mute status
            muteButtonLabel.setText("Unmute");
        }
        if (muteButtonLabel.getText().equals("Unmute")){
            //set microphone to unmute status
            muteButtonLabel.setText("Mute");
        }

    }

    @FXML
    protected void onCameraButtonClick(){
        //activate camera function
        //deactivate camera function
    }

    @FXML
    protected void onDisconnectButtonClick(){
        //disconnect the user from the call
    }

    @FXML
    protected void  onQuitButtonClick(){
        Platform.exit();
    }


}