# Internship Program (IP) 2021-22 - LP3 Phase.
# csv to tsv converter.
# with user input and extra if elses.


import pandas as pd

print('\n -------------------------------welcome to .csv to .tsv/ .tsv to .csv converter------------------------------- ')

while True:

    print('plese choose what operation you want to perform with your files!')

    print(' -csv -if you want to convert .csv to .tsv')
    print(' -tsv -if you want to convert .tsv to .csv')
    print(' - ex - Exit')
    
    #take input from user
    operation =input('')
    
    #.csv to .tsv operation
    if operation == 'csv':
        try:
            csv_file_name = input("Enter .csv file name/path: ")
            csv_read = pd.read_csv(csv_file_name)
            new_tsv_file = input("please specify a name for your new .tsv file: ")
            with open(new_tsv_file,'w') as tsvf:
                tsvf.write(csv_read.to_csv(sep='\t',index=False))
            print('Success!!')
        except Exception as e:
            print('Error while converting .csv to .tsv !!')
            print('Error: ',e)

    #.tsv to .csv operation
    elif operation == 'tsv':
        try:
            tsv_file_name = input("Enter .tsv file name/path: ")
            tsv_read = pd.read_csv(tsv_file_name,sep='\t')
            new_tsv_file = input("please specify a name for your new .csv file: ")
            with open(new_tsv_file,'w') as csvf:
                csvf.write(tsv_read.to_csv(sep=',',index=False))
            print("Success!!")
        except Exception as e:
                    print('Error while converting .tsv to .csv !!')
                    print('Error: ',e)

    #exit without performing any operations
    elif operation == 'ex':
        break

    #if user want to continue or not
    exit = input('continue / quit: ')
    if(exit == 'continue'):
        continue
    elif(exit=='quit'):
        break



