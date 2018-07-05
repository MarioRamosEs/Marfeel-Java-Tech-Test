# Marfeel Tech Test
Spring based web crawler that automatically detects Marfeelizable sites.

The application exposes a REST API that can receive a set of site URLs in JSON
format. For every URL, your crawler will visit the site and perform the test to determine if the site is Marfeelizable or not. Then it  persists the results of the site qualification in a MySQL DB.

# Use
- In your MySQL manager, create a DB named "techtest". Set a correct username and password of the database in the "aplication.properties" file.
- Post a Json in the route "/api/marfeelCheck"
- Enjoy the results. They are also stored in the DB.

# JSon Example
```
[{
        "url": "elpais.com/tag/fecha/ultimahora",
        "rank": 2
    },
    {
        "url": "centrallecheraasturiana.es",
        "rank": 834987
    },
    {
        "url": "guiafull.com",
        "rank": 571272
    },
    {
        "url": "leasing4business.co.uk",
        "rank": 435035
    },
    {
        "url": "ayto-arganda.es",
        "rank": 678918
    }
] 
```