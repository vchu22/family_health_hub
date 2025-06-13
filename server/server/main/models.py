from abc import ABC
from django.db import models
from django.contrib.auth.models import User  # Importing the built-in User model
from datetime import date

preset_pictures = ["", ""]

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

    def set_template_picture(self, idx: int):
        self.picture = preset_pictures[idx]
        self.save()
    
    def calculate_age(self):
        today = date.today()
        age = today.year - self.birthdate.year - ((today.month, today.day) < (self.birthdate.month, self.birthdate.day))
        return age
    
    def __str__(self):
        return self.name

class Person(Member):
    admin = models.BooleanField(default=False)
    user = models.OneToOneField(User, on_delete=models.CASCADE, related_name='member_profile', null=True, blank=True) # link to an account

class Pet(Member):
    species = models.CharField(max_length=15)
    breed = models.CharField(max_length=30, blank=True)