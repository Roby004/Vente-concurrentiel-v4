import React,{useState} from 'react';
import { Button, Container, Paper, TextField, Typography,Box } from '@mui/material';
import axios from 'axios'; 
import { useNavigate } from 'react-router-dom'; 
import { outlinedInputClasses } from '@mui/material/OutlinedInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import IconButton from '@mui/material/IconButton';

const LoginPage = () => {
  //recup data
  const [mail, setMail] = useState('');
  const [password, setPassword] = useState('');
  const [username, setUsername] = useState(''); 
  const [error, setError] = useState(''); 
   // afficher et cacher le mot de passe
   const [showPassword, setShowPassword] = React.useState(false);

  const handleClickShowPassword = () => setShowPassword((show) => !show);
 
  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };
  const redirige = useNavigate(); 

  const handleLogin = async (event) => {
    event.preventDefault();
    
    try {
      if (!mail || !password) {
        setError('Veuillez remplir les champs.');
        return;
      }
  
      const response = await axios.post('http://localhost:8092/auth/fournisseur/login', { mail, password });
  
      if (response.status === 200) {
        const { isAdmin,fournisseurId } = response.data;
     
        if (isAdmin) {
          console.log("admin authentifié");
          redirige('/admin/dashboard');
        } else if(fournisseurId) {
         localStorage.setItem('fournisseurId', fournisseurId);
          redirige('/dashboard-fournisseur');
        }
        
      }
    } catch (error) {
      setError('Échec:', error.response ? error.response.data : error.message);
      console.error('Login échec:', error.response ? error.response.data : error.message);
    }
  };
  
  {/*const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };*/}
  return (
    <Container maxWidth="sm" style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', minHeight: '100vh' }}>
      <Paper elevation={3} sx={{ padding: '20px',align:"center" }}>
      {/*<Typography variant="h5" gutterBottom sx={{textAlign: 'center',color:'orange'}}>
           LOGIN
  </Typography>*/}
  <Box style={{ display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
  <img src="/logo.png" alt="Tsena" width="80px" />
  <img src="/logotsena.png" alt="Tsena" width="80px" />
  </Box>
        <form >
          <TextField
            label="Email"
            type="email"
            fullWidth
            margin="normal"
            variant="outlined"
            value={mail}
            onChange={(e) => setMail(e.target.value)}
          />
          {/*<TextField
            label="Password"
            type="password"
            fullWidth
            margin="normal"
            variant="outlined"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
  />*/}
          <FormControl sx={{mt: 2, width: '100%' }} variant="outlined">
          <InputLabel htmlFor="outlined-adornment-password">Mot de passe</InputLabel>
          <OutlinedInput
            id="outlined-adornment-password"
            type={showPassword ? 'text' : 'password'}
            endAdornment={
              <InputAdornment position="end">
                <IconButton
                  aria-label="toggle password visibility"
                  onClick={handleClickShowPassword}
                  onMouseDown={handleMouseDownPassword}
                  edge="end"
                >
                  {showPassword ? <VisibilityOff /> : <Visibility />}
                </IconButton>
              </InputAdornment>
            }
            label="mot de passe"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            
          />
        </FormControl>

            { error && <p className="text-danger">{error}</p> }

          <Button type="submit" variant="contained" fullWidth
           sx={{ marginTop: '20px',
                 background: 'linear-gradient(90deg, rgba(255,109,109,0.8688725490196079) 0%, rgba(255,184,27,1) 100%)', //linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)
                  borderRadius: 3,
                  border: 0,
                  color: 'white',
                  height: 48,
                  padding: '0 30px',
                  boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)', }} onClick={handleLogin}>
            Login
          </Button>
          <Container> 
                        <p>Vous n'etes pas encore membre? <a href="/signup-fournisseur" >S'enregistrer</a></p> 
                    </Container> 
        </form>
      </Paper>
    </Container>
  );
};

export default LoginPage;