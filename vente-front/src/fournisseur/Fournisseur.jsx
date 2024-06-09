import FrCard from '../components/frCard.jsx';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
 // Import the component
import '../App.css';
import ResponsiveAppBar from '../components/navbar';
import { Routes, Route } from 'react-router-dom';
import FournisseurContent from './FrContent.jsx';
import DashboardPage from "./Dashboard.jsx"; // Corrected import path


function Fournisseur() {
  return (
    <>
      
      <FournisseurContent />
    </>
  );
}


export default Fournisseur;