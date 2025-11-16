# from django.shortcuts import render
from django.http import HttpResponse

# # Create your views here.
# def home(request):
#     return HttpResponse("Welcome to my Django site wow!")

from django.shortcuts import render
from django.views import View
def home(request):
    return render(request, 'home.html', {'name': 'Sujjal Khadka'})

class HelloSujjal(View):
    def get(self, request):
        return HttpResponse("Hello Sujjal bro")