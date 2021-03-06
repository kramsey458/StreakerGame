package logic.controllers;

import javafx.stage.Stage;
import javafx.scene.Scene;
import logic.views.*;

public class ViewFactory {
	
	private Stage stage;

	public ViewFactory(Stage stage) {
		this.stage = stage;
	}

	public void setStage(Stage stage){
		this.stage = stage;
	}

		
	public void updateView(VIEW_TYPE vt) {
		StreakerView newView;
		switch(vt) {
		case MAIN_MENU:
			newView = new MainMenuView(this);
			updateView(newView.setupScene());
			break;
		case GAMEPLAY:
			newView = new GameplayView(this);
			updateView(newView.setupScene());
			((GameplayView)newView).startGameLoop();
			break;
		case SETTINGS:
			newView = new SettingsView(this);
			updateView(newView.setupScene());
			break;
		case HELP:
			newView = new HelpView(this);
			updateView(newView.setupScene());
			break;
		case GAME_OVER:
			newView = new GameOverView(this);
			updateView(newView.setupScene());
			break;
		default:
			StreakerView newViewDefault;
			newViewDefault = new MainMenuView(this);
			updateView(newViewDefault.setupScene());
			break;
		}
	}

	public void start(){
		updateView(VIEW_TYPE.GAMEPLAY);
	}
	
	public void updateViewGameOver(String hms, int collected) {
		GameOverView newView = new GameOverView(this, hms, collected);
		updateView(newView.setupScene());
	}
	
	private void updateView(Scene scene) {
		stage.setScene(scene);
		stage.show();
	}
	
	/*
	 * Items will be added to this list as
	 * we flush out specific functionalities,
	 * i.e. pause menu, settings menu, etc.
	 * 
	 * TO_DO: upon adding a new view type to
	 * this list, make sure to add the new 
	 * material to the updateView switch
	 * block to include the addition.
	 */
	public enum VIEW_TYPE {
		MAIN_MENU,
		GAMEPLAY,
		GAME_OVER,
		PAUSE_MENU,
		SETTINGS,
		HELP
	}
}
