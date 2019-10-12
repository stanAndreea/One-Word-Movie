# **One Word Movie**

## *One Word Movie with the API from TheMovieDB and with Picasso and Volley librarys*

**App contains 3 activity:**

### **First Activity (*MainActivity*)**
The user must enter one word in the name of the movie
This **activity** send the word to the *Secound Activity*

![**Main Activity**](https://user-images.githubusercontent.com/35422422/66703768-a126ff00-ed1e-11e9-909c-dc36c8145478.png)

### **Secound Activity (*MovieActivity*)**
This activity the data from *MainActivity* and will send the request to the API **The Movie DataBase**, to receive the movies the user wants

To deserealize the data received from the api MovieDb, I used **Volley** library

![**List Movie**](https://user-images.githubusercontent.com/35422422/66703814-34603480-ed1f-11e9-8ecd-a2ad5033669a.jpg)

1.To display the poster of the movie I used the **Picasso** library.

2.If the movie don't hava a poster, the app putting a default image

![**Default Image**](https://user-images.githubusercontent.com/35422422/66704431-b30ba080-ed24-11e9-8654-4b556e6f19c0.png)


### **Third Activity (*DetailsActivity*)**

Will be displayed details about the movie the user wants

![**Details Activity**](https://user-images.githubusercontent.com/35422422/66704591-fb778e00-ed25-11e9-8f30-fb9e86b783ff.png)
