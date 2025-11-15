import qrcode

url = input("Enter the url: ").strip()
file_path = "/home/sujjalbtw/Projects/mycodingbasics/python/HarvardCS/advanced/qrcode.png"

qr = qrcode.QRCode()
qr.add_data(url)

img = qr.make_image()

img.save(file_path)

print("QR code was generated")

