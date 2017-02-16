<%@ include file="weather-search-form.jspf" %>

<h1>Results</h1>

<p>Date: ${weather.date}</p>
<p>City: ${weather.cityName}</p>
<p>Description: ${weather.description}</p>
<p>Temperature (Celcius): ${weather.temperature}&deg;C</p>
<p>Temperature (Farenheit): ${weather.farenheitTemperature}F</p>
<p>Time of Sunrise*: ${weather.sunrise}</p>
<p>Time of Sunset*: ${weather.sunset}</p>

<p>* Please note all times are in GMT</p>

<a href="/index">Return to search page</a>