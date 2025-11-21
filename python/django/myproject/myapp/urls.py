from django.urls import path
from . import views

urlpatterns = [
    path('', views.home, name='home'),
    # fixed: use as_view() for class-based view
    path('sujjal/', views.HelloSujjal.as_view(), name='sujjal'),
    path('function/', views.home, name='function'),
    path('class/', views.HelloSujjal.as_view(), name='class'),
    path('reservation', views.index)
]
