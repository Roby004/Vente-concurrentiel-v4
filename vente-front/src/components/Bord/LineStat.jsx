import React from 'react';
import './dash.css';
import { LineChart } from '@mui/x-charts/LineChart';
import Paper from '@mui/material/Paper';

const LineStat = () =>{
    return(
        <Paper elevation={2} sx={{minWidth:'300px',width:'350px',alignItems:'center',position:'absolute',padding:'10px'}}>
          <div className='chartL'>
          <LineChart 
      xAxis={[{ 
        data: [1, 2, 3, 5, 8, 10] ,
        ...xAxisStyle,
      }]}
      series={[
        {
          data: [2, 5.5, 2, 8.5, 1.5, 5],
          area: true,
        },
     
      ]}
      width={330}
      height={200}
    /></div>
      <p>Suivi des ventes</p>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Incidunt, modi iste laborum debitis, .</p>
          </Paper>
    )
}
export default LineStat;