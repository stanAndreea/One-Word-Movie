# **One Word Movie**

## *One Word Movie created using the API from TheMovieDB, Picasso and Volley librarys*

**App contains 3 activities:**

### **First Activity (*MainActivity*)**
The user must enter one word as the name of the movie he wants to search for

This **activity** sends the requested movie title to the *Second Activity*

![**Main Activity**](https://user-images.githubusercontent.com/35422422/66703768-a126ff00-ed1e-11e9-909c-dc36c8145478.png)

### **Second Activity (*MovieActivity*)**
In this activity, the data from *MainActivity* will send a request to **The Movie DataBase**, in order to receive movies that the user wants to review

To deserialize the data received from the API MovieDb, I used **Volley** library

![**List Movie**](https://user-images.githubusercontent.com/35422422/66703814-34603480-ed1f-11e9-8ecd-a2ad5033669a.jpg)

1.To display the poster of the movie I used the **Picasso** library.

2.If the movie doesn't have a poster, the application puts in place a default image

![**Default Image**](https://user-images.githubusercontent.com/35422422/66704431-b30ba080-ed24-11e9-8654-4b556e6f19c0.png)


### **Third Activity (*DetailsActivity*)**

Will display details about the movie that the user wants to review

![**Details Activity**](https://user-images.githubusercontent.com/35422422/66704591-fb778e00-ed25-11e9-8f30-fb9e86b783ff.png)
