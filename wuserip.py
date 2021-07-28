# Internship Program (IP) 2021-22 - LP3 Phase.
# csv to tsv converter.
# with user input.

import pandas as pd

try:
    
    # csv and tsv file names
    csv_file_name = input('enter .csv file name/path: ')
    tsv_file_name = input('enter .tsv file name/path: ')

    #read data from the given files
    csv_read = pd.read_csv(csv_file_name)
    tsv_read = pd.read_csv(tsv_file_name, sep='\t')

    # write the data to new files
    new_csv_file_name = input('enter new .csv file name: ')
    new_tsv_file_name = input('enter new .tsv file name: ')

    with open(new_csv_file_name,'w') as csv_file:
            csv_file.write(tsv_read.to_csv(sep=',', index=False, header=None))

    with open(new_tsv_file_name,'w') as tsv_file:
            tsv_file.write(csv_read.to_csv(sep='\t', index=False, header=None))

except Exception as e:
    print('Error: ',e)


