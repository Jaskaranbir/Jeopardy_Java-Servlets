/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaskaranbir.beans;

import java.util.ArrayList;

/**
 *
 * @author jaska
 */
public class LoadGame implements java.io.Serializable {
    
    ArrayList<Question> questions;
    
    public LoadGame() {
        questions = new ArrayList();
        String category = "Dora the Explorer";
        
        questions.add(new Question(category, 200, "In what season is the episode \"Beaches\" found?", new String[]{"Season 1", "Quiz 5", "Homework Assign 11", "How to disable button?"}, "1"));
        questions.add(new Question(category, 400, "What is the name of Dora's best monkey friend?", new String[]{"Pikachu", "Jaskaranbir", "Hairy Putter", "Highheels"}, "4"));
        questions.add(new Question(category, 600, "What is the name of the fox who always tries to take Dora's things?", new String[]{"Fred", "That guy", "Netbeans", "Robber"}, "4"));
        questions.add(new Question(category, 800, "Where does Dora keep all of her things?", new String[]{"MCLaughlin M6", "Java Bean", "Her Backpack", "In a servlet"}, "3"));
        questions.add(new Question(category, 1000, "What is Dora's last name?", new String[]{"Trump",  "Torres", "Jackson", "Clinton"}, "2"));
        
        
        category = "Potato";
        questions.add(new Question(category, 200, "How much potatoes do people eat every year?", new String[]{"33KG", "1.56milligrams", "140 pounds", "Sia - Elastic Heart"}, "1"));
        questions.add(new Question(category, 400, "What's the weight of biggest potato?", new String[]{"ahh, no.", "3.76KG", "140 pounds", "Eminem - Rap God"}, "2"));
        questions.add(new Question(category, 600, "What are the origins of word potato?", new String[]{"Pootato", "Pah-toto", "Ptato", "Patata"}, "4"));
        questions.add(new Question(category, 800, "How do you spell potato?", new String[]{"java", "servlets", "Potato", "Apache JerryMouse"}, "3"));
        questions.add(new Question(category, 1000, "Which country is leading producer of Potato?", new String[]{"Asgard", "Pacific Ocean", "Mount Everest", "China"}, "4"));
        
        category = "Study";
        questions.add(new Question(category, 200, "What do we want?", new String[]{"A+ Grades", "Tomatoes", "Dem lemons", "Fresh air"}, "1"));
        questions.add(new Question(category, 400, "What do we usually get?", new String[]{"Meh", "B Grades!", "More lemons", "Exploding Samsung Note 7s"}, "2"));
        questions.add(new Question(category, 600, "How many people failed/almost failed in java 3 lasteth semest'r? (According to Sanchay)", new String[]{"10.4", "Two and Half Men", "40 Thieves", "10"}, "4"));
        questions.add(new Question(category, 800, "What does sir Jonathan say about quizes that end at 12am?", new String[]{"Do not start them at 11:59pm", "Nothing really", "Free marks", "Whatever"}, "1"));
        questions.add(new Question(category, 1000, "Zombies?", new String[]{"Zombies. (braaiiins)", "yes", "agreed", "dasodfjoij"}, "1"));
        
        category = "Game of Thrones";
        questions.add(new Question(category, 200, "The most epic TV show ever?", new String[]{"Game of Thrones", "Vampire Dairies", "Mythbusters", "Girls Gone WIld"}, "1"));
        questions.add(new Question(category, 400, "What is the usual per episode length of world's most epic tv show?", new String[]{"Thing never ends", "1 Hour", "22 seconds 4 milliseconds", "Garbage Collector"}, "2"));
        questions.add(new Question(category, 600, "Who still knows nothing?", new String[]{"Jaskaranbir", "Adele - Hello", "Jon Snow", "Pentagon"}, "3"));
        questions.add(new Question(category, 800, "What's best about game of thrones?", new String[]{"The Ladies", "The Epic Story", "Definitely the ladies", "Ladies FTW"}, "2"));
        questions.add(new Question(category, 1000, "The best character in game of thrones?", new String[]{"The Ladies", "Cersei", "Robert Baratheon", "Tyrion Lannister"}, "4"));
        
        category = "Random Shoot";
        questions.add(new Question(category, 200, "Can a match box?", new String[]{"Yes", "No", "No, but a tin can", "yes, one beat Mike Tyson"}, "3"));
        questions.add(new Question(category, 400, "Sdrawkcab noitseuq siht rewsna?", new String[]{"K.O.", "What?", "I don't understand", "Tennis Elbow"}, "1"));
        questions.add(new Question(category, 600, "Square root of Onion?", new String[]{"28", "Carrots", "Shallots", "Pi"}, "3"));
        questions.add(new Question(category, 800, "The answer is really big.", new String[]{"Really Big", "Elephant", "Infinity", "Java"}, "2"));
        questions.add(new Question(category, 1000, "Huh?", new String[]{"Hmm.", "Ah.", "I see....", "Ok..."}, "1"));
    }
    
    public ArrayList<Question> getQuestions(){
        return questions;
    }
}
