from django.db import models
from django.contrib.auth import get_user_model
from datetime import date

User = get_user_model()
preset_pictures = ["", ""]

class Household(models.Model):
    name = models.CharField(max_length=64)
    created_at = models.DateTimeField(auto_now_add=True)

# abstract class
class Member(models.Model):
    household = models.ForeignKey(Household, related_name='members', on_delete=models.CASCADE)
    name = models.CharField(max_length=64)
    dob = models.DateField()
    picture = models.URLField(blank=True)

    class Meta:
        abstract = True
    
    def set_template_picture(self, idx: int):
        self.picture = preset_pictures[idx]
        self.save()
    
    def calculate_age(self):
        today = date.today()
        age = today.year - self.dob.year - ((today.month, today.day) < (self.dob.month, self.dob.day))
        return age
    
    def __str__(self):
        return self.name

class Person(Member):
    admin = models.BooleanField(default=False)
    user = models.OneToOneField(User, on_delete=models.CASCADE, related_name='member_profile', null=True, blank=True)
    
    # More nuanced gender/sex options for people
    GENDER_CHOICES = [
        ('M', 'Male'),
        ('F', 'Female'),
        ('MF', 'Male-to-Female Transgender'),
        ('FM', 'Female-to-Male Transgender'),
        ('NB', 'Non-Binary'),
        ('GF', 'Gender Fluid'),
        ('O', 'Other'),
        ('P', 'Prefer not to say'),
    ]
    gender = models.CharField(max_length=2, choices=GENDER_CHOICES, blank=True)

class Pet(Member):
    species = models.CharField(max_length=15)
    breed = models.CharField(max_length=30, blank=True)
    
    # Biological sex for pets
    SEX_CHOICES = [
        ('M', 'Male'),
        ('F', 'Female'),
        ('NM', 'Neutered Male'),
        ('SF', 'Spayed Female'),
        ('I', 'Intersex'),
        ('U', 'Unknown'),
        ('NA', 'Not Applicable'),
    ]
    sex = models.CharField(max_length=2, choices=SEX_CHOICES, blank=True)