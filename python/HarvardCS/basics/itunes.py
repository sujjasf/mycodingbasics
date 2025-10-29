# import requests
# import sys

# if len(sys.argv) != 2:
#     print("Usage: python itunes.py <search-term>")
#     sys.exit(1)
# search_term = sys.argv[1]

# response = requests.get('https://itunes.apple.com/search?entity=song&limit=1&term=' + search_term)

# if response.status_code == 200:
#     data = response.json()
#     if data['resultCount'] > 0:
#         song = data['results'][0]
#         print("Title:", song['trackName'])
#         print("Artist:", song['artistName'])
#         print("Album:", song['collectionName'])
#     else:
#         print("No results found.")
# else:
#     print("Error:", response.status_code)

import json
import requests
import sys
if len(sys.argv) != 2:
    sys.exit()
response = requests.get('https://itunes.apple.com/search?entity=song&limit=4&term=' + sys.argv[1])
# print(json.dumps(response.json(), indent=2))
o = response.json()
for result in o["results"]:
    print(result["trackName"])