
year=int(input("Enter the year"))
if year % 4 == 0:
    print(" TRUE")
elif year % 100!=0:
    print(" FALSE")
elif year % 400 == 0:
    print("TRUE")
