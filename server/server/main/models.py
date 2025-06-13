from abc import ABC
from django.db import models
from django.contrib.auth.models import User  # Importing the built-in User model

class Household(models.Model):
    name = models.CharField(max_length=64)
    created_at = models.DateTimeField(auto_now_add=True)

# abstract class
class Member(models.Model, ABC):
    household = models.ForeignKey(Household, related_name='members', on_delete=models.CASCADE)
    name = models.CharField(max_length=64)
    dob = models.DateField
    sex = models.CharField(max_length=1, choices=[('M','Male'),('F','Female'), ('T', 'Trans'), ('O', 'Other')], blank=True)
    picture = models.URLField(blank=True)

class Person(Member):
    admin = models.BooleanField(default=False)
    user = models.OneToOneField(User, on_delete=models.CASCADE, related_name='member_profile', null=True, blank=True)

class Pet(Member):
    name = models.CharField(max_length=50)
    species = models.CharField(max_length=15)
    breed = models.CharField(max_length=30, blank=True)
    def __str__(self):
        return self.name