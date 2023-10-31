import React from 'react';
import {render,screen} from '@testing-library/react';
import ErrorPage from './ErrorPage';


test('Error Message should be displayed',() => {
   const errorMsg = 'Error 404';
   const errorPage = render(<ErrorPage/>);
   expect(errorPage.getByTestId('error-msg').textContent).toBe(errorMsg);
});
