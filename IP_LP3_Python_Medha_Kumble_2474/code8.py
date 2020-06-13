def sum_series(n):
  if n < 1:
    return 0
  else:
    return n + sum_series(n - 2)

n=int(input('Enter the value for n:'))
print(sum_series(n))



