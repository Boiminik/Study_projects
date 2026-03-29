import requests
file_url = "https://www.db-book.com/slides-dir/PDF-dir/ch1.pdf"
 
r = requests.get(file_url, stream = True)
 
with open("python.pdf","wb") as pdf:
         for chunk in r.iter_content(chunk_size=1024):
                   '''
                   writing one chunk at a time to pdf file
                   '''
                   if chunk:
                       pdf.write(chunk)
