# IPL Cricket Score Prediction Android Application

🏏 Welcome to our Cricket Score Prediction Android Application repository! This project aims to revolutionize cricket analytics by providing real-time, accurate score predictions for Indian Premier League (IPL) matches. Leveraging machine learning algorithms, Kotlin, and TensorFlow Lite, our app delivers precise forecasts for the final 20-over score.

## Project Overview
We are developing an Android application that accurately predicts cricket scores using machine learning algorithms. Users input crucial match data such as the first innings team, current score, wickets, overs, last 5 overs score, and last 5 overs wickets. By analyzing extensive ball-to-ball IPL match datasets, our model generates precise forecasts for the final 20-over score.

## Significance of the Project
Our application aims to revolutionize cricket analytics by providing real-time, accurate score predictions. This enhances users' understanding and anticipation of the game's progression, making it an invaluable tool for cricket enthusiasts.

## Problem Statement
Our Android application utilizes regression and decision tree machine learning algorithms to predict IPL cricket innings scores accurately. Developed with Kotlin and Jetpack, users input crucial match data such as the first innings team, current score, wickets, overs, last 5 overs score, and last 5 overs wickets. By analyzing extensive ball-to-ball IPL match datasets, our model generates precise forecasts for the final 20-over score.

## Technology Stack
- **Machine Learning:** Python with libraries such as Scikit-learn for model development and TensorFlow Lite for model deployment.
- **Backend Development:** Kotlin.
- **User Interface:** Jetpack for an intuitive and user-friendly UI.

## Data Source
We are leveraging comprehensive ball-to-ball data from recent IPL matches to train our machine learning model. Dataset link: [IPL Dataset on Kaggle](https://www.kaggle.com/datasets/civilwarrior/iplcsv)

## Machine Learning Model
- **Regression Algorithms:** Multiple regression and decision tree regression algorithms are used to predict the score at the end of 20 overs based on the provided input data.
- **Linear Regression:** Establishes a linear relationship between input features and the target variable (score at the end of 20 overs).
- **Decision Tree:** Handles non-linear relationships and interactions between different features to improve prediction accuracy.

## Model Integration
After training and validating our machine learning models, we convert them into TensorFlow Lite format using the TFLiteConverter. The converted TFLite model is then integrated into our Android application, allowing users to get accurate score predictions even without an internet connection.

## 📥 Direct APK Download

You can download the latest version of the IPL SCORE PREDICTION APK by clicking the link below:

[IPL SCORE PREDICTION APK](https://drive.google.com/file/d/1H2aALpOXH8bXTgGKqYxnEl-mj5U6BIg6/view?usp=sharing)

## Screenshots 📱
<details>
  <summary>Main Screen</summary>
  <img src="https://github.com/premganesh321/IPL_Score_Prediction/blob/master/sc1.jpg" alt="" width="300"/>
</details>
<details>
<summary>Second Screen</summary>
  <img src="https://github.com/premganesh321/IPL_Score_Prediction/blob/master/sc2.jpg" alt="" width="300"/>
</details>
<details>
<summary>Third Screen</summary>
  <img src="https://github.com/premganesh321/IPL_Score_Prediction/blob/master/sc3.jpg" alt="" width="300"/>
</details>
<details>
<summary>Prediction Screen</summary>
  <img src="https://github.com/premganesh321/IPL_Score_Prediction/blob/master/sc4.jpg" alt="" width="300"/>
</details>


## Expected Outcome
Our application provides users with real-time score predictions for the 20th over, enhancing their understanding and anticipation of the game's progression.

## Note
Please note that the User Interface (UI) development is currently in progress. We are continuously working to enhance the UI to provide a seamless and user-friendly experience. Stay tuned for updates!
