import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import FournisseurPage from './fournisseur/Fournisseur.jsx';
import DashboardPage from './fournisseur/Dashboard.jsx'; 
import DetailPage from './fournisseur/Detail.jsx';
import ProfilFrPage from './fournisseur/ProfilFr.jsx';
import AidePage from './fournisseur/Aide.jsx';
import LoginFrPage from './fournisseur/LoginPage.jsx';
import SignUpFrPage from './fournisseur/SignUp.jsx';
import AccueilPage from './Accueil.jsx';

import Accueil from './client/user/js/accueil'
import Avis from './client/user/js/avis'
import Panier from './client/user/js/panier'
import Profil from './client/user/js/profil'
import BoxProduit from './client/user/js/boxProduit'
import Historique from './client/user/js/historique'
import Activite from './client/user/js/activite'
import Facture from './client/user/js/facture'
import Login from './client/login/login'
import Suscribe from './client/suscribe/suscribe'

import Modals from './modal/modal'
import CancelIcon from '@mui/icons-material/Cancel'
import HelpIcon from '@mui/icons-material/Help'
import Snackbars from './modal/snackbar'
import CheckCircleIcon from '@mui/icons-material/CheckCircle'
import WarningIcon from '@mui/icons-material/Warning'
import InfoIcon from '@mui/icons-material/Info'

import AdminClient from './admin/adminClient'
import AdminFournisseur from './admin/adminFournisseur'
import AdminProduit from './admin/adminProduit'
import AdminAchat from './admin/adminAchat'
import AdminDashboard from './admin/adminDashboard'

function App() {
  return (
    
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/fournisseur" element={<FournisseurPage />} />
        <Route path="/dashboard-fournisseur" element={<DashboardPage />} />
        <Route path="/login-fournisseur" element={<LoginFrPage />} />
        <Route path="/signup-fournisseur" element={<SignUpFrPage />} />
        <Route path="/detail/:idPro" element={<DetailPage />} />
        <Route path="/profil/fournisseur" element={<ProfilFrPage />} />
        <Route path="/aide" element={<AidePage />} />

        

        <Route path="/login-client" element={<Login />} />
        <Route path="/suscribe" element={<Suscribe />} />  
        <Route path="/boxProduit" element={<BoxProduit />} />
        <Route path="/accueil-client" element={<Accueil />} />
        <Route path="/avis" element={<Avis />} />
        <Route path="/panier" element={<Panier />} />
        <Route path="/profil" element={<Profil />} />
        <Route path="/historique" element={<Historique />} />
        <Route path="/activite" element={<Activite />} />
        <Route path="/admin/client" element={<AdminClient />} />
        <Route path="/admin/fournisseur" element={<AdminFournisseur />} />
        <Route path="/admin/produit" element={<AdminProduit />} />
        <Route path="/admin/dashboard" element={<AdminDashboard />} />
        <Route path="/admin/achat" element={<AdminAchat />} />
        <Route path="/facture" element={<Facture/>} />
      </Routes>
  );
}

function HomePage() {
  return (
    <div className="acc">
      <AccueilPage />
    </div>
  );
}

export default App;
