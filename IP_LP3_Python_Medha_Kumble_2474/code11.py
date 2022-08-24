import datetime

s=input('Enter in the format year,month,day:')

year,month,day=map(int,s.split(','))
a_date = datetime.date(year,month,day)
week_number = a_date.isocalendar()[1]

print(week_number)

